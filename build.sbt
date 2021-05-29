import sbt.Resolver

name := "krystal-bull"

version := "0.1"

scalaVersion := "2.13.5"

organization := "org.bitcoin-s"

libraryDependencies ++= Deps.core

fork / run := true

mainClass := Some("com.krystal.bull.gui.GUI")

resolvers += Resolver.sonatypeRepo("snapshots")

resolvers +=
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

enablePlugins(ReproducibleBuildsPlugin, JavaAppPackaging, GraalVMNativeImagePlugin, WindowsPlugin)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", _ @ _*) => MergeStrategy.discard
  case PathList("reference.conf", _ @ _*) => MergeStrategy.concat
  case _ => MergeStrategy.first
}

scalacOptions ++= Seq("release", "11")

// general package information (can be scoped to Windows)
maintainer := "Chris Stewart <stewart.chris1234@gmail.com>"
packageSummary := "A discreet log contract oracle"
packageDescription := "A discreet log contract oracle"

// wix build information
wixProductId := "ce07be71-510d-414a-92d4-dff47631848a"
wixProductUpgradeId := "4552fb0e-e257-4dbd-9ecb-dba9dbacf424"
