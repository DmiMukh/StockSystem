package ru.hackathone.core.inventoryApi.staff.client

import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.staff.dto.TaskRequest

interface StaffClient {
    suspend fun getTaskList(): HttpResponse
    suspend fun getTaskListByStatus(statusName: String): HttpResponse

    suspend fun createTask(task: TaskRequest): HttpResponse
    suspend fun updateTask(taskId: Int, task: TaskRequest): HttpResponse
    suspend fun deleteTask(taskId: Int, statusId: Int): HttpResponse

    suspend fun getStatusList(): HttpResponse

    suspend fun getStaffList(): HttpResponse
    suspend fun getWorkerTasksById(taskId: Int): HttpResponse

    suspend fun assignTask(workerId: Int, taskId: Int): HttpResponse
}