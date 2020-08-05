package com.varadha2k.hello;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.varadha2k.hello");

        noClasses()
            .that()
            .resideInAnyPackage("com.varadha2k.hello.service..")
            .or()
            .resideInAnyPackage("com.varadha2k.hello.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.varadha2k.hello.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
