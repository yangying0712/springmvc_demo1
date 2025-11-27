package org.xd.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xd.pojo.Dept;
import org.xd.pojo.Result;
import org.xd.service.DeptService;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

//    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        //System.out.println("查询全部的部门数据");
        log.info("查询全部的部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     * @param request
     * @return
     * 方式一：使用HttpServletRequest获取请求参数
     */

//        @DeleteMapping("/depts")
//        public Result delete(HttpServletRequest request){
//            String idStr = request.getParameter("id");
//            int id = Integer.parseInt(idStr);
//            System.out.println("删除部门id为："+id);
//            return Result.success();
//        }

    /**
     * 删除部门
     * @param deptId
     * @return
     * 方式二：使用@RequestParam注解获取请求参数
     * 注意事项：一旦声明了@RequestParam注解，那么该参数在请求时必须传递，否则会报错
     */

    //    @DeleteMapping("/depts")
    //    public Result delete(@RequestParam(value = "id",required = false) Integer deptId) {
    //        System.out.println("根据ID删除部门："+deptId);
    //        return Result.success();
    //    }

    /**
     * 方式三：省略@RequestParam注解（前端传递的请求参数名称和服务端方法的形参名称一致）【推荐】
     */
    @DeleteMapping
    public Result delete(Integer id) {
//        System.out.println("根据ID删除部门："+id);
        log.info("根据ID删除部门：{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
//        System.out.println("新增部门："+dept);
        log.info("新增部门：{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据ID查询
     * @param id
     */
/*    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable("id") Integer deptid) {
        System.out.println("根据ID查询部门数据："+deptid);
        //Dept dept = deptService.getInfo(deptid);
        return Result.success();
    }*/
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
//        System.out.println("根据ID查询部门数据："+id);
        log.info("根据ID查询部门数据：{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 根据ID更新部门数据
     * @param dept
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
//        System.out.println("修改部门："+dept);
        log.info("修改部门：{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
