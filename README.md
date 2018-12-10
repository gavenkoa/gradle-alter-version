
# Demo of Gradle issue with late version redefinition

If `version` from `gradle.properties` is redefined by Gradle plugin inside `project.afterEvaluate`
then `maven-publish` plugin fails to find `.jar` inside `build/libs`:

    * What went wrong:
    Execution failed for task ':publishJarPublicationToBuildRepository'.
    > Failed to publish publication 'jar' to repository 'build'
       > Invalid publication 'jar': artifact file does not exist:
         'C:\home\tmp\gradle-alter-version\build\libs\gradle-alter-version-0.8.jar'

Here `0.8` is inside `gradle.properties` and plugin redefines version to `0.2`:

    $ ls build/libs
    gradle-alter-version-0.2.jar

To run into issue:

    $ gradle publishJarPublicationToBuildRepository

