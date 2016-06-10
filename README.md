# sbt-ammonite

*SBT plugin to ease the launch of [Ammonite](https://github.com/lihaoyi/Ammonite)*

[![Build Status](https://travis-ci.org/alexarchambault/sbt-ammonite.svg)](https://travis-ci.org/alexarchambault/sbt-ammonite)

**sbt-ammonite** is a SBT plugin that adds a `ammonite:run` command to SBT,
that launches an [Ammonite](https://github.com/lihaoyi/Ammonite) session
against the current project.

## Quick start

Add to your `~/.sbt/0.13/plugins/build.sbt`,
```scala
resolvers += Resolver.sonatypeRepo("releases")

addSbtPlugin("com.github.alexarchambault" %% "sbt-ammonite" % "0.1.2")
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

Tested with SBT 0.13.9, and Scala 2.10.5, 2.11.7, and 2.11.8. (Other Scala versions supported by Ammonite, and SBT down to 0.13.5 are expected
to work too.)

## Bumping the Ammonite version

The Ammonite version is set via the `ammoniteVersion` key. It reads its value:
- from the `AMMONITE_VERSION` environment variable if set, else
- from the `ammonite.version` Java property if set, else it
- fallbacks to an hard-coded default version (currently, `0.6.0`).

Set the `AMMONITE_VERSION` environment variable or the `ammonite.version` Java
property to bump the Ammonite version.

## Known issues

* Incompatible with the recent versions of `sbt-ensime` (from `0.3.2` to `0.5.0` at least, [#9](https://github.com/alexarchambault/sbt-ammonite/issues/9))
* Incompatible with [`sbt-coursier`](https://get-coursier.io)

## Notice

Copyright 2015-16, Alexandre Archambault

Released under a MIT license
