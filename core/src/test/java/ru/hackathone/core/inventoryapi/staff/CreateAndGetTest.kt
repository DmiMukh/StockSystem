package ru.hackathone.core.inventoryapi.staff

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
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

    @Test
    fun createTask1() = runBlocking() {
        val taskList1 = service.getTaskList()
        val size1 = taskList1.size

        val id = service.createTask(task1)
        println("Id = $id")
        val taskList2 = service.getTaskList()
        val size2 = taskList2.size
        println(taskList2)
        assertEquals(size1 + 1, size2)
    }

    @Test
    fun createTask2() = runBlocking() {
        val taskList1 = service.getTaskList()
        val size1 = taskList1.size

        val id = service.createTask(task2)

        val taskList2 = service.getTaskList()
        val size2 = taskList2.size
        println(taskList2)
        assertEquals(size1 + 1, size2)
    }
}