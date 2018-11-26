package com.huatong.controller;
import com.alibaba.fastjson.JSON;
import com.huatong.annotation.DynamicDatasource;
import com.huatong.domain.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By xzz on 2018/10/29
 */

@Api("swagger2测试（xzz）")
@RestController
@DynamicDatasource("this is type annotation")
public class RestTemplateTestController {

    @DynamicDatasource("this is field")
    private String name;



    @DynamicDatasource("my first annotation test")
    @RequestMapping(value = "/rest",method = RequestMethod.POST)
    @ApiOperation("swagger2测试")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "student",value = "名字",dataType = "Student",required = true)})
    public String getJsonStr(@RequestBody Student student){
        Student stu = new Student(student.getName(),23);
        System.out.println("git reset -hard 01");
        return JSON.toJSONString(stu);
    }


}
