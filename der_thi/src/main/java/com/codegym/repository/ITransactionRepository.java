package com.codegym.repository;

import com.codegym.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
        Page<Transaction> findAllByCustomer_NameContaining(String name, Pageable pageable);

//        @Query(value="select * from transaction where employee_name like %:employeeName% and employee_adress like %:employeeAdress%  " +
//                "and position_id like %:position% and education_degreeid like %:educationDegree% and division_id like %:division% and flag_delete_employee = 1" ,nativeQuery=true)
//        Page<Transaction> search(@Param("employeeName") String employeeName ,
//                                      @Param("employeeAdress")String employeeAdress ,
//                                      @Param("position") String position,
//                                      @Param("educationDegree") String educationDegree,
//                                      @Param("division") String division,
//                                      Pageable pageable);
//        Page<Transaction> findAllByServiceType_NameContaining(String name, Pageable pageable);
//        Page<Transaction> findByServiceTypeAndId(Integer id,Pageable pageable);
}
