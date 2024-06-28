package ru.hackathone.core.inventoryapi.staff

import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import ru.hackathone.core.inventoryApi.staff.client.StaffClientImpl
import ru.hackathone.core.inventoryApi.staff.dto.TaskRequest
import ru.hackathone.core.provideKtorHttpClient

class StaffClientTest {
    private val client = StaffClientImpl(provideKtorHttpClient())

    @Test
    fun createTask() = runBlocking {
        val response = client.createTask(
            TaskRequest(
                "Add feature",
                "You have to add feature in the ims-staff application",
                1,
                0
            )
        )

        assertEquals(response.status, HttpStatusCode.OK)
    }


    @Test
    fun updateTask() = runBlocking {
        val response = client.updateTask(
            0,
            TaskRequest(
                "Add feature",
                "Just write some tests",
                1,
                0
            )
        )
        assertEquals(response.status, HttpStatusCode.OK)
    }

    @Test
    fun deleteTask() = runBlocking {
        val response = client.deleteTask(
            0,
            1
        )
        assertEquals(response.status, HttpStatusCode.OK)
    }

    @Test
    fun getTaskList() = runBlocking {
        val response = client.getTaskList()
        assertEquals(response.status, HttpStatusCode.OK)
    }

    @Test
    fun getStaffList() = runBlocking {
        val response = client.getStaffList()
        assertEquals(response.status, HttpStatusCode.OK)
    }

    @Test
    fun getStatusList() = runBlocking {
        val response = client.getStatusList()
        assertEquals(response.status, HttpStatusCode.OK)
    }

    @Test
    fun getTaskListByStatus() = runBlocking {
        val response = client.getTaskListByStatus("")
        assertEquals(response.status, HttpStatusCode.OK)
    }

    @Test
    fun getWorkerTasksById() = runBlocking {
        val response = client.getWorkerTasksById(0)
        assertEquals(response.status, HttpStatusCode.OK)
    }

    @Test
    fun assignTask() {
        //val response = client.assignTask()
    }
}