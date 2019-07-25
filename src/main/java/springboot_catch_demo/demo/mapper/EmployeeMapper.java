package springboot_catch_demo.demo.mapper;

import org.apache.ibatis.annotations.*;
import springboot_catch_demo.demo.bean.Employee;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id  = #{id}")
    public Employee getEmpById(Integer id);
    @Select("select * from employee where last_name  = #{lastName}")
    public Employee getEmpByLastName(String lastName);
    @Update("update employee  set lastName = #{lastName} ,gender = #{gender} ,email = #{email} ,d_id = #{dId} where id = #{id}")
    public void updateEmp(Employee employee);

    @Insert("insert into employee (lastName,gender,email,d_id) values(#{lastName},#{gender},#{email},#{dId}")
    public void insertEmp(Employee employee);
    @Delete("delete from employee where id = #{id}")
    public void deleteEmpById(Integer id );
}
