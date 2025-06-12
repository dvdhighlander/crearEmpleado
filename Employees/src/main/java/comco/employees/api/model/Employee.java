package comco.employees.api.model;

import java.time.LocalDate;

public record Employee (
String name,
String surename,
String documentType,
String document,
LocalDate birthdate,
LocalDate startDate,
String position,
double salary) {


}
