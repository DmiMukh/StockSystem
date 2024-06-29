package ru.hackathone.core.inventoryApi.staff.service

import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import ru.hackathone.core.inventoryApi.exceptions.NoContentException
import ru.hackathone.core.inventoryApi.exceptions.UnknownStatusCodeException
import ru.hackathone.core.inventoryApi.staff.client.StaffClient
import ru.hackathone.core.inventoryApi.staff.dto.TaskRequest
import ru.hackathone.core.inventoryApi.staff.models.Id
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
       return try{
        val response = client.getTaskList()
        when (response.status) {
            HttpStatusCode.OK -> {
                return response.body<Array<Task>>()
            }

            else -> throw UnknownStatusCodeException()
        }}
       catch (e:NoContentException) {
       return arrayOf()}
    }

    override suspend fun getTaskListByStatus(statusName: String): Array<Task> {
        return try {
            val response = client.getTaskListByStatus(statusName)
            when (response.status) {
                HttpStatusCode.OK -> return response.body<Array<Task>>()
                else -> throw UnknownStatusCodeException()
            }
        } catch (e: NoContentException) {
            return arrayOf()

        }
    }


    override suspend fun getWorkerTasksById(workerId: Int): Array<Task> {
        return try {
            val response = client.getWorkerTasksById(workerId)
            when (response.status) {
                HttpStatusCode.OK -> {
                    return response.body<Array<Task>>()
                }

                else -> throw UnknownStatusCodeException()
            }
        } catch (e: NoContentException) {
            return arrayOf()
        }
    }


    override suspend fun getStatusList(): Array<TaskStatus> {
        return try {
            val response = client.getStatusList()
            when (response.status) {
                HttpStatusCode.OK -> {
                    response.body<Array<TaskStatus>>()
                }

                else -> throw UnknownStatusCodeException()
            }
        } catch (e: NoContentException) {
            return arrayOf()
        }
    }

    override suspend fun getStaffList(): Array<Staff> {
        return try {
            val response = client.getStaffList()
            when (response.status) {
                HttpStatusCode.OK -> {
                    response.body<Array<Staff>>()
                }

                else -> throw UnknownStatusCodeException()
            }
        } catch (e: NoContentException) {
            return arrayOf()
        }
    }

    /**
     * can throw AlreadyReportedException
     */
    override suspend fun createTask(task: TaskRequest): Int {
        return client.createTask(task).body<Id>().id
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