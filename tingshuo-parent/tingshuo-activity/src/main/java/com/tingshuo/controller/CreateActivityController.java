package com.tingshuo.controller;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

/**
 * 类文件描述: 工作流任务提交
 *  任务流程->zhangsan创建出差申请->lisi审批（项目经理审批）->wangwu审批(部门经理审批)->zhaoliu审批(财务审批)->end
 * @author yangz
 * @version 1.0.0
 * @date 2022年12月25日 16:16
 **/
public class CreateActivityController {
    //创建依赖基本表
    @Test
    public void testCreateDbTable(){
        // 2 一般创建方式 使用这种方式更加灵活 不用像默认方式一样写死配置文件和bean
        // 使用自定义方式创建 配置文件的名字可以自定义,bean的名字也可以自定义
        ProcessEngineConfiguration processEngineConfigurationFromResource = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml","processEngineConfiguration");
        // 获取流程引擎对象
        ProcessEngine processEngine = processEngineConfigurationFromResource.buildProcessEngine();
    }
    //  测试流程部署
    @Test
   public void testEvection() {
        // 1.创建ProcessEngine
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        // 2.使用ProcessEngine得到操作数据库的服务(RepositoryService)
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
        // 3.使用RepositoryService进行流程部署，定义一个流程的名字，把bpmn文件和png文件部署到数据库里
        Deployment deployment = repositoryService.createDeployment()
                .name("出差申请流程")
                .addClasspathResource("bpnm/evection.bpmn") //资源文件 bpmn配置文件
                .addClasspathResource("bpnm/evection.png") //资源文件 png流程图
                .disableSchemaValidation()//禁止校验文件
                .deploy();
        // 4.输出部署信息
        System.out.println("流程部署的ID:" + deployment.getId());
        System.out.println("流程部署的名字:" + deployment.getName());
    }
    // 启动流程实例
    @Test
    public void testStartProcess() {
        // 1.创建ProcessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2.获取RuntimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 3.根据流程定义的id启动流程
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("evection");
        // 4.输出内容
        System.out.println("流程定义ID = " + instance.getProcessDefinitionId());
        System.out.println("流程实例ID = " + instance.getId());
        System.out.println("当前活动的ID = " + instance.getActivityId());
    }
    // 根据任务id完成个人任务
    @Test
    public void testCompletTask() {
        // 1 获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2 获取service
        TaskService taskService = processEngine.getTaskService();
        // 3 根据任务id查询任务
        taskService.complete("17502");
    }
    // 根据任务id完成个人任务
    //流程发起->zhangsan->lisi->wangwu->zhaoliu->流程结束
    @Test
    public void testCompletTaskNew(){
        // 1 获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2 获取service
        TaskService taskService = processEngine.getTaskService();
        // 3 获取jerry在myEvection中对应的任务 我们已知只有一个任务 可使用singleResult获取一个结果集
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("evection") // 流程的key
                .taskAssignee("lisi")   // 要查询的负责人
                .singleResult();// 因为可能有多个待办  所以是一个集合

        System.out.println("流程实例ID:"+task.getProcessInstanceId());
        System.out.println("任务ID:"+task.getId());
        System.out.println("任务负责人:"+task.getAssignee());
        System.out.println("任务名称:"+task.getName());

        // 4 获取lisi的完成任务
        taskService.complete(task.getId());


    }
    // 根据任务id完成个人任务
    @Test
    public void testCompletTaskNewOne(){
        // 1 获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2 获取service
        TaskService taskService = processEngine.getTaskService();

        // 3 获取zhangsan在myEvection中对应的任务 我们已知只有一个任务 可使用singleResult获取一个结果集
        //Task task = taskService.createTaskQuery()
        //        .processDefinitionKey("myEvection") // 流程的key
        //        .taskAssignee("jerry")   // 要查询的负责人
        //        .singleResult();// 因为可能有多个待办  所以是一个集合
        //
        //3 获取jerry在myEvection中对应的任务 我们已知只有一个任务 可使用singleResult获取一个结果集
        //Task task = taskService.createTaskQuery()
        //        .processDefinitionKey("myEvection") // 流程的key
        //        .taskAssignee("jerry")   // 要查询的负责人
        //        .singleResult();// 因为可能有多个待办  所以是一个集合

        // 3 获取jack在myEvection中对应的任务 我们已知只有一个任务 可使用singleResult获取一个结果集
        //Task task = taskService.createTaskQuery()
        //        .processDefinitionKey("myEvection") // 流程的key
        //        .taskAssignee("jack")   // 要查询的负责人
        //        .singleResult();// 因为可能有多个待办  所以是一个集合
        //
        //System.out.println("流程实例ID:"+task.getProcessInstanceId());
        //System.out.println("任务ID:"+task.getId());
        //System.out.println("任务负责人:"+task.getAssignee());
        //System.out.println("任务名称:"+task.getName());

        // 3 获取rose在myEvection中对应的任务 我们已知只有一个任务 可使用singleResult获取一个结果集
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("evection") // 流程的key
                .taskAssignee("rose")   // 要查询的负责人
                .singleResult();// 因为可能有多个待办  所以是一个集合

        // 4 获取jerry的完成任务
        taskService.complete(task.getId());


    }


}
