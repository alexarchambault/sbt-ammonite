# sbt-ammonite

*SBT plugin to ease the launch of [Ammonite](https://github.com/lihaoyi/Ammonite)*

[![Build Status](https://travis-ci.org/alexarchambault/sbt-ammonite.svg)](https://travis-ci.org/alexarchambault/sbt-ammonite)

**sbt-ammonite** is a SBT plugin that adds a `ammonite:run` command to SBT,
that launches an [Ammonite](https://github.com/lihaoyi/Ammonite) session
against the current project.

## Quick start

Add to your `~/.sbt/0.13/plugins/build.sbt`,
```scala
resolvers += Resolver.sonatypeRepo("snapshots")

addSbtPlugin("com.github.alexarchambault" %% "sbt-ammonite" % "0.1.0-SNAPSHOT")
```

Then at the prompt of a SBT project, type
```scala
ammonite:run
```
instead of `console`.

To include the test build products, type
```scala
ammonite-test:run
```
instead of `test:console`.

These two commands can be scoped along specific projects too, like
```scala
core/ammonite:run
```
or
```scala
generic/ammonite-test:run
```

Initial commands, specified with `initialCommands in console`,
are also taken into account, and supplied to Ammonite as predef.

Tested with SBT 0.13.9, and Scala 2.10.5 and 2.11.7. (Other Scala versions supported by Ammonite, and SBT down to 0.13.5 are expected
to work too.)

(Non-snapshot release in a few days.)

## Notice

Copyright 2015, Alexandre Archambault

Released under a MIT license
