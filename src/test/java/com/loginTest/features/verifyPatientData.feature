Feature: Verify patient data

  Scenario Outline: Verify patient data for patient ID
    Given User opened the Pharmacist portal
    And User logged in with username "hardstop-pharmacist6@mailinator.com" and password "Password1#"
    And User navigates to the patient page
    When User enters the patient ID "<PatientID>"
    Then The patient details should match the following:
      | First Name    | Last Name                       | Hosp 30d | DOB        | Sex    | Age | Pt. Lang. | Insurance #     | Insurance Co.                     |
      | <FirstName>   | <LastName>                     | <Hosp30d> | <DOB>     | <Sex>  | <Age> | <PtLang> | <InsuranceNum> | <InsuranceCo>                     |

    Examples:
      | PatientID                            | FirstName                     | LastName                     | Hosp30d | DOB        | Sex    | Age | PtLang    | InsuranceNum    | InsuranceCo                     |
      | 6c3f2efb-c0fa-464d-a7fc-a0065407b9e5 | Hardstop                      | Select health test patient 4 | No      | 01/01/1965 | female | 59  | English   | XD723643612345  | Hardstop SelectHealth           |
      | 4059581a-e693-455a-8d6b-4fc5a1ea3cc6 | Hardstop                      | Select health test patient 3 | No      | 01/01/1965 | female | 59  | English   | XD723643612345  | Hardstop SelectHealth           |
      | 8db898eb-bd30-4635-aaa2-bd42abd99eff | Hardstop                      | Select health test patient 5 | No      | 01/01/1965 | female | 59  | English   | XD723643612345  | Hardstop SelectHealth           |
      | a89a0a0c-4202-4b64-949a-5e48c16d1aea | Select concierge test patient 8 | Hardstop                     | No      | 01/01/1965 | female | 59  | English   | XD723643612345  | Hardstop SelectHealth Concierge |
