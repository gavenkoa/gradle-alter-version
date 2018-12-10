package home

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Optional

class AlterVer implements Plugin<Project> {
    void apply(Project project) {
        def extension = project.extensions.create('alterVer', AlterVerExtension)
        project.afterEvaluate {
            project.version = extension.version;
        }
    }
}

class AlterVerExtension {
    String version = '0.1'
}
