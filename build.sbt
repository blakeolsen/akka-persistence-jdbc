
organization := "com.github.dnvriend"

name := "akka-persistence-jdbc"

version := "1.1.7"

scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.10.5", "2.11.7")

resolvers += "krasserm at bintray" at "http://dl.bintray.com/krasserm/maven"

libraryDependencies ++= {
    val akkaVersion = "2.3.12"
    Seq(
    "com.typesafe.akka"   %% "akka-actor"                    % akkaVersion,
    "com.typesafe.akka"   %% "akka-persistence-experimental" % akkaVersion,
    "org.scalikejdbc"     %% "scalikejdbc"                   % "2.2.7",
    "commons-codec"        % "commons-codec"                 % "1.10",
    "ch.qos.logback"       % "logback-classic"               % "1.1.2"           % Test,
    "com.typesafe.akka"   %% "akka-slf4j"                    % akkaVersion       % Test,
    "ch.qos.logback"       % "logback-classic"               % "1.1.2"           % Test,
    "org.postgresql"       % "postgresql"                    % "9.4-1201-jdbc41" % Test,
    "com.h2database"       % "h2"                            % "1.4.181"         % Test,
    "mysql"                % "mysql-connector-java"          % "5.1.33"          % Test,
    "com.typesafe.akka"   %% "akka-testkit"                  % akkaVersion       % Test,
    "org.scalatest"       %% "scalatest"                     % "2.1.4"           % Test,
    "org.pegdown"          % "pegdown"                       % "1.4.2"           % Test,
    "com.github.krasserm" %% "akka-persistence-testkit"      % "0.3.4"           % Test
  )
}

autoCompilerPlugins := true

parallelExecution in Test := false

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

publishMavenStyle := true

licenses += ("Apache-2.0", url("http://opensource.org/licenses/apache2.0.php"))

//testOptions in ThisBuild += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")

// enable scala code formatting //
import scalariform.formatter.preferences._

scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(RewriteArrowSymbols, true)

// enable updating file headers //
import de.heikoseeberger.sbtheader.license.Apache2_0

headers := Map(
    "scala" -> Apache2_0("2015", "Dennis Vriend"),
    "conf" -> Apache2_0("2015", "Dennis Vriend", "#")
)

// enable plugins //
lazy val akkaPersistenceJdbc = project
  .in(file("."))
  .enablePlugins(AutomateHeaderPlugin)
