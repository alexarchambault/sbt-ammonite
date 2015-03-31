name := "sbt-ammonite"

sbtPlugin := true

organization := "com.github.alexarchambault"

scalacOptions += "-target:jvm-1.7"

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

licenses := Seq(
  "MIT license" -> url("http://www.opensource.org/licenses/mit-license.php")
)

pomExtra := {
  <url>https://github.com/alexarchambault/sbt-ammonite</url>
  <scm>
    <url>git://github.com/alexarchambault/sbt-ammonite.git</url>
    <connection>scm:git://github.com/alexarchambault/sbt-ammonite.git</connection>
  </scm>
  <developers>
    <developer>
      <id>alexarchambault</id>
      <name>Alexandre Archambault</name>
      <url>https://github.com/alexarchambault</url>
    </developer>
  </developers>
}

credentials += {
  Seq("SONATYPE_USER", "SONATYPE_PASS").map(sys.env.get) match {
    case Seq(Some(user), Some(pass)) =>
      Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", user, pass)
    case _ =>
      Credentials(Path.userHome / ".ivy2" / ".credentials")
  }
}

releaseSettings

ReleaseKeys.versionBump := sbtrelease.Version.Bump.Bugfix

sbtrelease.ReleasePlugin.ReleaseKeys.publishArtifactsAction := PgpKeys.publishSigned.value
