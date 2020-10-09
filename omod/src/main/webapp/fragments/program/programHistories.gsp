<% programs.each { descriptor -> %>
${ ui.includeFragment("keaddonexample", "program/programHistory", [ patient: patient, program: descriptor.target, showClinicalData: showClinicalData ]) }
<% } %>