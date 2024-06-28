package ru.hackathone.core.inventoryapi.staff

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import ru.hackathone.core.inventoryApi.staff.client.StaffClientImpl
import ru.hackathone.core.inventoryApi.staff.dto.TaskRequest
import ru.hackathone.core.inventoryApi.staff.service.StaffServiceImpl
import ru.hackathone.core.provideKtorHttpClient

class StaffServiceTest {
    private val client = StaffClientImpl(provideKtorHttpClient())
    private val service = StaffServiceImpl(client)
    private val task1 = TaskRequest(
        "Add feature",
        "You have to add feature in the ims-staff application",
        1,
        0
    )
    private val task2 = TaskRequest(
        "Add feature",
        "Just write some tests",
        2,
        0
    )
    //@Test
    //fun assignTask()

    @Test
    fun getLists() = runBlocking {
       // val taskList = service.getTaskList()
       // println(taskList)

       // val staffList = service.getStaffList()
       // println(staffList)

        val statusList = service.getStatusList()
        println(statusList)

        assertEquals(1, 2)
    }

    @Test
    fun getTaskListByStatus() = runBlocking {
        val taskList = service.getTaskListByStatus(statusName = "Wait")
        println(taskList)

        for (task in taskList) {
            assertEquals(1, task.statusId)
        }
    }

    @Test
    fun getWorkerTasksById() = runBlocking {
        val taskList = service.getWorkerTasksById(0)
        println(taskList)

        for (task in taskList) {
            assertEquals(1, 2)
        }
    }

    @Test
    fun createTask() = runBlocking {
        val beforeTaskList = service.getTaskList()
        val before = beforeTaskList.size

        service.createTask(task1)
        val afterTaskList = service.getTaskList()
        val after = afterTaskList.size

        println(beforeTaskList)
        println(afterTaskList)

        assertEquals(before + 1, after)
    }

    @Test
    fun updateTask() = runBlocking {
        val beforeTaskList = service.getTaskList()
        val beforeSize = beforeTaskList.size
        println(beforeTaskList)

        service.createTask(task1)
        service.updateTask(beforeSize, task2)

        val afterTaskList = service.getTaskList()
        val after = afterTaskList.size
        println(afterTaskList)

        assertEquals(afterTaskList[after - 1], task2)
    }

    @Test
    fun deleteTask() = runBlocking {
        val beforeTaskList = service.getTaskList()
        val beforeSize = beforeTaskList.size
        println(beforeTaskList)

        service.createTask(task1)
        service.deleteTask(beforeSize, task1.statusId)

        val afterTaskList = service.getTaskList()
        val afterSize = afterTaskList.size
        println(afterTaskList)

        assertEquals(beforeSize, afterSize)
    }
}