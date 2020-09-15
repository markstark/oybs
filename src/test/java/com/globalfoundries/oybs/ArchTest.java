package com.globalfoundries.oybs;

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
            .importPackages("com.globalfoundries.oybs");

        noClasses()
            .that()
            .resideInAnyPackage("com.globalfoundries.oybs.service..")
            .or()
            .resideInAnyPackage("com.globalfoundries.oybs.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.globalfoundries.oybs.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
