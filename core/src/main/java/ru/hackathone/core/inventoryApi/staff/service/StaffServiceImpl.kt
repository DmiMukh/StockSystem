package ru.hackathone.core.inventoryApi.staff.service

import android.content.res.Resources.NotFoundException
import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import ru.hackathone.core.inventoryApi.exceptions.BadRequestException
import ru.hackathone.core.inventoryApi.exceptions.UnknownStatusCodeException
import ru.hackathone.core.inventoryApi.staff.client.StaffClient
import ru.hackathone.core.inventoryApi.staff.dto.TaskRequest
import ru.hackathone.core.inventoryApi.staff.models.Staff
import ru.hackathone.core.inventoryApi.staff.models.Task
import ru.hackathone.core.inventoryApi.staff.models.TaskStatus

/**
 * Service can throws:
 * SerializationException if client is broken
 * except CRUD:
 * TransformationFoundException if response body mismatched expected type
 * HTTP Exceptions:
 * NotFoundException (android)
 * BadRequestException (custom)
 * UnknownStatusCodeException (custom)
 */
class StaffServiceImpl(val client: StaffClient) : StaffService {
    override suspend fun getTaskList(): Array<Task> {
        val response = client.getTaskList()
        when (response.status) {
            HttpStatusCode.OK -> {
                return response.body<Array<Task>>()
            }

            HttpStatusCode.NotFound -> throw NotFoundException()
            HttpStatusCode.BadRequest -> throw BadRequestException()
            else -> throw UnknownStatusCodeException()
        }
    }

    override suspend fun getTaskListByStatus(statusName: String): Array<Task> {
        val response = client.getTaskListByStatus(statusName)
        when (response.status) {
            HttpStatusCode.OK -> {
                return response.body<Array<Task>>()
            }

            HttpStatusCode.NotFound -> throw NotFoundException()
            HttpStatusCode.BadRequest -> throw BadRequestException()
            else -> throw UnknownStatusCodeException()
        }
    }


    override suspend fun getWorkerTasksById(taskId: Int): Array<Task> {
        val response = client.getWorkerTasksById(taskId)
        when (response.status) {
            HttpStatusCode.OK -> {
                return response.body<Array<Task>>()
            }

            HttpStatusCode.NotFound -> throw NotFoundException()
            HttpStatusCode.BadRequest -> throw BadRequestException()
            else -> throw UnknownStatusCodeException()
        }
    }


    override suspend fun getStatusList(): Array<TaskStatus> {
        val response = client.getStatusList()
        when (response.status) {
            HttpStatusCode.OK -> {
                return response.body<Array<TaskStatus>>()
            }

            HttpStatusCode.NotFound -> throw NotFoundException()
            HttpStatusCode.BadRequest -> throw BadRequestException()
            else -> throw UnknownStatusCodeException()
        }
    }

    override suspend fun getStaffList(): Array<Staff> {
        val response = client.getStaffList()
        when (response.status) {
            HttpStatusCode.OK -> {
                return response.body<Array<Staff>>()
            }

            HttpStatusCode.NotFound -> throw NotFoundException()
            HttpStatusCode.BadRequest -> throw BadRequestException()
            else -> throw UnknownStatusCodeException()
        }
    }

    /**
     * can throw AlreadyReportedException
     */
    override suspend fun createTask(task: TaskRequest) {
        client.createTask(task)
    }

    override suspend fun updateTask(taskId: Int, task: TaskRequest) {
        client.updateTask(taskId, task)
    }

    override suspend fun deleteTask(taskId: Int, statusId: Int) {
        client.deleteTask(taskId, statusId)
    }

    override suspend fun assignTask(workerId: Int, taskId: Int) {
        client.assignTask(workerId, taskId)
    }
}