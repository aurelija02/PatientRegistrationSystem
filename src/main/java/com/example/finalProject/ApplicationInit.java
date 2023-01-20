package com.example.finalProject;

import com.example.finalProject.role.Role;
import com.example.finalProject.role.RoleRepo;
import com.example.finalProject.role.RolesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInit implements ApplicationRunner {

    @Autowired
    RoleRepo repo;

    @Override
    public void run (ApplicationArguments args){

        if (repo.findByRole(RolesEnum.ROLE_PATIENT).isEmpty()){
            Role patient = new Role();
            patient.setRole(RolesEnum.ROLE_PATIENT);
            repo.save(patient);
        }

        if (repo.findByRole(RolesEnum.ROLE_DOCTOR).isEmpty()){
            Role doctor = new Role();
            doctor.setRole(RolesEnum.ROLE_DOCTOR);
            repo.save(doctor);
        }

        if (repo.findByRole(RolesEnum.ROLE_ADMIN).isEmpty()){
            Role admin = new Role();
            admin.setRole(RolesEnum.ROLE_ADMIN);
            repo.save(admin);
        }
    }

}
