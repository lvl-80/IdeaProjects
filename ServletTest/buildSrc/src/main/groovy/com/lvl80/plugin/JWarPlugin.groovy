package com.lvl80.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy

class JWarPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        addCopyWarToTomcat(project)
        addJarWithDependencies(project)
    }

    void addCopyWarToTomcat(Project project) {
        def map = [group: "jwar", type: Copy]
        project.task(map, "copyWarToTomcat") {
            doLast() {
                project.from(project.war.archiveFile.get())
                project.into("/Users/nikitasudaev/apache-tomcat-9.0.64/webapps/")
            }
        }
    }

    void addJarWithDependencies(Project project) {
        def map = [group: "jwar", type: Copy]
        project.task(map,"jarWithDependencies") {
            doLast() {
                project.jar {
                    project.from {
                        project.configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it) }
                    }
                }
            }
        }
    }
}
