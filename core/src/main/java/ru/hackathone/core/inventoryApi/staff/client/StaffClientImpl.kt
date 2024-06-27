package ru.hackathone.core.inventoryApi.staff.client

import io.ktor.client.HttpClient
import io.ktor.client.HttpClient.*
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import ru.hackathone.core.inventoryApi.staff.models.Task
import ru.hackathone.core.inventoryApi.staff.models.TaskStatus

class StaffClientImpl(private val client: HttpClient) : StaffClient {
    private val addr = "http://localhost:8090"

    override suspend fun getAllTasks(): HttpResponse {
        return client.get("$addr/task/")
    }

    override suspend fun getTaskListByStatusName(taskStatus: TaskStatus): HttpResponse {
        return client.get("$addr/task/status/$taskStatus")
    }

    override suspend fun getTaskById(taskId: Int): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun createTask(task: Task): HttpResponse {
        return client.post("$addr/task/create") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToJsonElement(task))
        }
    }

    override suspend fun updateTask(taskId: Int, task: Task): HttpResponse {
        return client.put("$addr/task/$taskId") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToJsonElement(task))
        }
    }

    override suspend fun deleteTask(taskId: Int): HttpResponse {
        return client.delete("$addr/task/delete") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToJsonElement(taskId))
        }
    }

    override suspend fun getStatusList(): HttpResponse {
        return client.get("$addr/status")
    }

    override suspend fun getStaffList(): HttpResponse {
        return client.get("$addr/managment/")
    }

    override suspend fun getWorkedTasksById(taskId: Int): HttpResponse {
        return client.get("$addr/$taskId")
    }

    override suspend fun assignTask(workerId: Int, taskId: Int): HttpResponse {
        return client.post("$addr/$workerId/task/$taskId")
    }
}