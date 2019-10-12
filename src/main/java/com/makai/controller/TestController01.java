package com.makai.controller;

import com.makai.mapper.DateMapper;
import com.makai.model.User;
import com.makai.model.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* * *
 *  @Name: TestController01
 *  @User: 马凯
 *  @Date: 2019/10/9
 *  @Remark:
 * * */
@RestController
public class TestController01 {

    @Autowired
    private DateMapper mapper;

    /*
    * 查询全部
    * get/user/get 参数A 返回ResultObject 200/400/500,{"msg","提示信息"，
    * */

    @RequestMapping(value="/user/get",method=RequestMethod.GET)
    public ResultObject getAll(){

        //从后端获取
        List<User> users = mapper.users();
        System.out.println("getAll:"+users);

        if(users == null || users.size() == 0){
            return new ResultObject(201,"没有数据",null);
        }
        return new ResultObject(200,"成功",users);
    }


    //查询一个
    @RequestMapping(value = "/user/get/{id}",method =RequestMethod.GET)
    public ResultObject getUserById(@PathVariable int id){
        System.out.println("getUserById id:"+ id);

        User user = mapper.getUserById(id);

        System.out.println("getUserById user:"+user);

        return new ResultObject(200,"成功",user);
    }

    //添加用户
    /*
    * 前段发送表单默认是一postman测试需要适应芙蓉-date的行是发送
    * ajax默认形式postman:x-www-from-urlencoded
    * ajax发送json数据：postman：row ->json
    *   而且：如果前台发送的json数据，后台遇到封装进对象，需要使用
    *   @Request
    * 个人理解：添加都是以from表单的形式进行的
    *
    * */
    @RequestMapping(value ="/user/add",method = RequestMethod.POST)
    ResultObject userAdd(@RequestBody User user){

        System.out.println("传进来的User："+user);
        int row = 0;

        try {
            row = mapper.addUser(user);
        } catch (Exception e){
            System.out.println("添加异常！");
            row = -1;
        }

        if (row > 0){
            return  new ResultObject(200,"成功",null);
        }

        return new ResultObject(404,"失败",user);
    }

    /*
     删除对象
    * */
    @RequestMapping(value = "/user/delete/{id}",method = RequestMethod.DELETE)
    public ResultObject deleteUserById(@PathVariable int id){

        System.out.println("deleteUserById id:"+id);

         int row=mapper.deleteUserById(id);

         if(row > 0){
             return new ResultObject(200,"删除成功！",null);
         } else {
             return new ResultObject(201,"没有该用户！",null);
         }

    }
    /*
    * 更新
    * */
    @RequestMapping(value = "/user/update",method = RequestMethod.PUT)
    ResultObject updateUserById(@RequestBody User user){
        System.out.println("传进来的值为："+user);

        int row = mapper.updateUserById(user);

        if(row > 0){
            return new ResultObject(200,"更新成功！",null);
        } else {
            return new ResultObject(201,"更新失败！",null);
        }
    }
}
