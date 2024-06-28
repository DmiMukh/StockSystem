package ru.hackathone.core.inventoryapi.staff

import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import ru.hackathone.core.inventoryApi.staff.client.StaffClientImpl
import ru.hackathone.core.inventoryApi.staff.dto.TaskRequest
import ru.hackathone.core.inventoryApi.staff.service.StaffServiceImpl
import ru.hackathone.core.provideKtorHttpClient

class CreateAndGetTest {
    private val client = StaffClientImpl(provideKtorHttpClient())
    private val service = StaffServiceImpl(client)
    private val task1 = TaskRequest(
        "Win the Hackathon",
        "Create application and show it",
        1,
        3
    )
    private val task2 = TaskRequest(
        "Win the Hackathon",
        "Create application and show it",
        1,
        4
    )

    @Before
    fun getBefore() = runBlocking {
        val tasklist = service.getTaskList()
        println(tasklist.size)
        println("task list = $tasklist")
    }

    @Test
    fun createTask1() = runBlocking() {
        val id = service.createTask(task1)
        val taskList = service.getTaskList()

        println(taskList)
        val count = taskList.size
        assertEquals(count - 1, id)
    }

    @Test
    fun createTask2() = runBlocking() {

        val id = service.createTask(task2)
        val taskList = service.getTaskList()

        println(taskList)
        val count = taskList.size
        assertEquals(count - 1, id)
    }

    @After
    fun gets() = runBlocking {
        val tasklist = service.getTaskList()
        println(tasklist.size)
        println("task list = $tasklist")
    }
}