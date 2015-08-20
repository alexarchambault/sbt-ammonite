package ammonite

import sbt._, Keys._

object AmmonitePlugin extends AutoPlugin {

  /** Configuration under which Ammonite is run */
  lazy val Ammonite = config("ammonite")

  /** Configuration under which Ammonite is run along with tests */
  lazy val AmmoniteTest = config("ammonite-test")


  val ammoniteVersion = settingKey[String]("Ammonite version")


  override def trigger = allRequirements

  override lazy val projectSettings =
    ammoniteSettings(Ammonite, Compile) ++
    ammoniteSettings(AmmoniteTest, Test)

  def ammoniteSettings(ammoniteConf: Configuration, underlyingConf: Configuration) = inConfig(ammoniteConf)(
    // Getting references to undefined settings when doing ammonite:run without these
    Defaults.compileSettings ++

    // Seems like the class path provided to ammonite:run doesn't take into account the libraryDependencies below
    // without these
    Classpaths.ivyBaseSettings ++

    Seq(
      ammoniteVersion := "0.4.5",

      libraryDependencies += "com.lihaoyi" %% "ammonite-repl" % ammoniteVersion.value cross CrossVersion.full,

      // Don't remember under which conditions these two were necessary
      libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value force(),
      ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) },

      configuration := underlyingConf,

      /* Overriding run and runMain defined by compileSettings so that they use fullClasspath of this scope (Ammonite),
       * taking into account the extra libraryDependencies above. */
      run <<= Defaults.runTask(fullClasspath, mainClass in run, runner in run),
      runMain <<= Defaults.runMainTask(fullClasspath, runner in run),

      mainClass := Some("ammonite.repl.Repl"),

      /* Required for the input to be provided to Ammonite */
      connectInput := true
    )
  )

}
