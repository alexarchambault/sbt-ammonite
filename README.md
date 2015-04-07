# sbt-ammonite

*SBT plugin to ease the launch of [Ammonite](https://github.com/lihaoyi/Ammonite)*

[![Build Status](https://travis-ci.org/alexarchambault/sbt-ammonite.svg)](https://travis-ci.org/alexarchambault/sbt-ammonite)

**sbt-ammonite** is a SBT plugin that adds a `repl` command to SBT,
that launches an [Ammonite](https://github.com/lihaoyi/Ammonite) session
against the current project.

## Quick start

Add to your `~/.sbt/0.13/plugins/build.sbt`,
```scala
resolvers += Resolver.sonatypeRepo("releases")

addSbtPlugin("com.github.alexarchambault" %% "sbt-ammonite" % "0.1.0-RC1")
```

For the development version, add instead
```scala
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

addSbtPlugin("com.github.alexarchambault" %% "sbt-ammonite" % "0.1.0-SNAPSHOT")
```

Then at the prompt of a SBT project, type
```scala
repl
```
instead of `console`.

Compatible with Scala 2.10.3 to 2.10.5, and 2.11.0 to 2.11.6.

Requires SBT >= 0.13.5 (for auto plugins).

## Notice

Copyright 2015, Alexandre Archambault

Released under a MIT license
