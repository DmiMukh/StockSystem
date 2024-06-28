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
import ru.hackathone.core.inventoryApi.staff.dto.TaskRequest

class StaffClientImpl(
    private val client: HttpClient,
    private val addr: String = "http://localhost:8000"
) : StaffClient {
    override suspend fun getTaskList(): HttpResponse {
        return client.get("$addr/task")
    }

    override suspend fun getTaskListByStatus(statusName: String): HttpResponse {
        return client.get("$addr/task/status/$statusName")
    }

    /**
     * can throw AlreadyReportedException
     */
    override suspend fun createTask(task: TaskRequest): HttpResponse {
        return client.post("$addr/task") {
            contentType(ContentType.Application.Json)
            setBody(task)
        }
    }

    override suspend fun updateTask(taskId: Int, task: TaskRequest): HttpResponse {
        return client.put("$addr/task/$taskId") {
            contentType(ContentType.Application.Json)
            setBody(task)
        }
    }

    override suspend fun deleteTask(taskId: Int, statusId: Int): HttpResponse {
        return client.delete("$addr/task/$taskId") {
            contentType(ContentType.Application.Json)
            setBody(statusId)
        }
    }

    override suspend fun getStatusList(): HttpResponse {
        return client.get("$addr/task/status")
    }


    override suspend fun getStaffList(): HttpResponse {
        return client.get("$addr/management")
    }

    override suspend fun getWorkerTasksById(taskId: Int): HttpResponse {
        return client.get("$addr/management/$taskId")
    }

    override suspend fun assignTask(workerId: Int, taskId: Int): HttpResponse {
        return client.post("$addr/management/$workerId/task/$taskId")
    }
}