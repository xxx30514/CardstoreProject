package cardstore.controller;

import cardstore.dao.EmployeeDao;
import cardstore.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Date:2022/7/8
 * Author:ybc
 * Description:
 * 查詢所有員工資訊-->/employee-->get
 * 跳轉到新增表單頁面-->/to/add-->get
 * 新增員工資訊-->/employee-->post
 * 跳轉到修改表單頁面-->/employee/1-->get
 * 修改員工資訊-->/employee-->put
 * 刪除員工資訊-->/employee/1-->delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //獲取所有員工資訊
        Collection<Employee> allEmployee = employeeDao.getAll();
        //將所有員工的資訊在請求域中共享
        model.addAttribute("allEmployee", allEmployee);
        //跳轉到列表頁面
        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        //新增員工資訊
        employeeDao.save(employee);
        //重定向到列表功能:/employee  getAllEmployee方法再次獲取所有員工資訊
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        //根據id查詢員工資訊
        Employee employee = employeeDao.get(id);
        //將員工資訊共享到請求域中
        model.addAttribute("employee", employee);
        //跳轉到employee_update.html
        return "employee_update";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        //修改員工資訊
        employeeDao.save(employee);
        //重定向到列表功能:/employee
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        //刪除員工資訊
        employeeDao.delete(id);
        //重定向到列表功能:/employee
        return "redirect:/employee";
    }
}
