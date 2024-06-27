package ru.hackathone.core.inventoryApi.staff.client

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ru.hackathone.core.inventoryApi.staff.models.Task

class StaffClientImpl(private val client: HttpClient) : StaffClient {
    private val addr = "http://localhost:8090"

    override suspend fun getTaskList(): HttpResponse {
        return client.get("$addr/task/")
    }

    override suspend fun getTaskListByStatus(statusName: String): HttpResponse {
        return client.get("$addr/task/$statusName")
    }

    /**
     * can throw AlreadyReportedException
     */
    override suspend fun createTask(task: Task): HttpResponse {
        return client.post("$addr/task/create") {
            contentType(ContentType.Application.Json)
            setBody(task)
        }
    }

    override suspend fun updateTask(taskId: Int, task: Task): HttpResponse {
        return client.put("$addr/task/$taskId") {
            contentType(ContentType.Application.Json)
            setBody(task)
        }
    }

    override suspend fun deleteTask(taskId: Int, statusId: Int): HttpResponse {
        return client.delete("$addr/task/delete/$taskId") {
            contentType(ContentType.Application.Json)
            setBody(statusId)
        }
    }

    override suspend fun getStatusList(): HttpResponse {
        return client.get("$addr/status/")
    }


    override suspend fun getStaffList(): HttpResponse {
        return client.get("$addr/management/")
    }

    override suspend fun getWorkerTasksById(taskId: Int): HttpResponse {
        return client.get("$addr/$taskId")
    }

    override suspend fun assignTask(workerId: Int, taskId: Int): HttpResponse {
        return client.post("$addr/$workerId/task/$taskId")
    }
}