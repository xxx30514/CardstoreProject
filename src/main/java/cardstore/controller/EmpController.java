package cardstore.controller;

import cardstore.dao.EmployeeDao;
import cardstore.pojo.Emp;
import cardstore.pojo.Employee;
import cardstore.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;

import java.util.Collection;
import java.util.List;

/**
 * Date:2022/7/8
 * Author:ybc
 * Description:
 * 查詢所有員工資訊-->/emp-->get
 * 跳轉到新增表單頁面-->/to/add-->get
 * 新增員工資訊-->/emp-->post
 * 跳轉到修改表單頁面-->/emp/1-->get
 * 修改員工資訊-->/emp-->put
 * 刪除員工資訊-->/emp/1-->delete
 */
@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查詢所有員工資訊
        List<Emp> list = empService.getAllEmp();
        //將所有員工的資訊在請求域中共享
        model.addAttribute("allEmployee",list);
        //跳轉到列表頁面
        return "employee_list2";
    }
    @RequestMapping(value = "/emp/page/{pageNo}", method = RequestMethod.GET)
    public String getEmpPage(@PathVariable("pageNo") Integer pageNo, Model model) {
		//獲取員工資訊與分頁資訊
    	PageInfo<Emp> page =empService.getEmpPage(pageNo);
    	//將分頁資訊與員工資訊共享在請求域中
    	model.addAttribute("page",page);
    	return "employee_list2";
	}
//    @RequestMapping(value = "/emp", method = RequestMethod.POST)
//    public String addEmployee(Employee employee){
//        //新增員工資訊
//        employeeDao.save(employee);
//        //重定向到列表功能:/employee  getAllEmployee方法再次獲取所有員工資訊
//        return "redirect:/employee";
//    }
//
//    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
//    public String toUpdate(@PathVariable("id") Integer id, Model model){
//        //根據id查詢員工資訊
//        Employee employee = employeeDao.get(id);
//        //將員工資訊共享到請求域中
//        model.addAttribute("employee", employee);
//        //跳轉到employee_update.html
//        return "employee_update";
//    }
//
//    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
//    public String updateEmployee(Employee employee){
//        //修改員工資訊
//        employeeDao.save(employee);
//        //重定向到列表功能:/employee
//        return "redirect:/employee";
//    }
//
//    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
//    public String deleteEmployee(@PathVariable("id") Integer id){
//        //刪除員工資訊
//        employeeDao.delete(id);
//        //重定向到列表功能:/employee
//        return "redirect:/employee";
//    }
}
