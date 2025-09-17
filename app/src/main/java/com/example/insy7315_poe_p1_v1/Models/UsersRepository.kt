package com.example.insy7315_poe_p1_v1.Models

import java.util.*

object UsersRepository {
    val users: MutableList<UsersModel> = mutableListOf(
        UsersModel("1", "Admin", "admin@example.com", "Admin@123", "Kaylee", "Blue Hill", "Active"),
        UsersModel("2", "Manager", "manager@example.com", "Manager@123", "Liam", "Florida Estate", "Active"),
        UsersModel("3", "Caretaker", "aisha.caretaker@example.com", "Caretaker@123", "Aisha", "Floral Park", "Active"),
        UsersModel("4", "Caretaker", "thabo.caretaker@example.com", "Caretaker@123", "Thabo", "Blue Hill", "On Leave"),
        UsersModel("5", "Tenant", "naledi.tenant@example.com", "Tenant@123", "Naledi", "Florida Estate", "Active"),
        UsersModel("6", "Tenant", "ethan.tenant@example.com", "Tenant@123", "Ethan", "Floral Park", "Active"),
        UsersModel("7", "Tenant", "amara.tenant@example.com", "Tenant@123", "Amara", "Blue Hill", "Active"),
        UsersModel("8", "Tenant", "sipho.tenant@example.com", "Tenant@123", "Sipho", "Floral Park", "Active")
    )

}