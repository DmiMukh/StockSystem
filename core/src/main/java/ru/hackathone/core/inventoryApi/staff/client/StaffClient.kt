package ru.hackathone.core.inventoryApi.staff.client

import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.staff.models.Task

interface StaffClient {
    suspend fun getTaskList(): HttpResponse
    suspend fun getTaskListByStatus(statusName: String): HttpResponse

    suspend fun createTask(task: Task): HttpResponse
    suspend fun updateTask(taskId: Int, task: Task): HttpResponse
    suspend fun deleteTask(taskId: Int, statusId: Int): HttpResponse

    suspend fun getStatusList(): HttpResponse

    suspend fun getStaffList(): HttpResponse
    suspend fun getWorkerTasksById(taskId: Int): HttpResponse

    suspend fun assignTask(workerId: Int, taskId: Int): HttpResponse
}