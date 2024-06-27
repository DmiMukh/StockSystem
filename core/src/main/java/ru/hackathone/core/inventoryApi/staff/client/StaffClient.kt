package ru.hackathone.core.inventoryApi.staff.client

import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.staff.models.Task
import ru.hackathone.core.inventoryApi.staff.models.TaskStatus

interface StaffClient {
    suspend fun getAllTasks(): HttpResponse
    suspend fun getTaskListByStatusName(taskStatus: TaskStatus): HttpResponse
    suspend fun getTaskById(taskId: Int): HttpResponse

    suspend fun createTask(task: Task): HttpResponse
    suspend fun updateTask(taskId: Int, task: Task): HttpResponse
    suspend fun deleteTask(taskId: Int): HttpResponse

    suspend fun getStatusList(): HttpResponse

    suspend fun getStaffList(): HttpResponse
    suspend fun getWorkedTasksById(taskId: Int): HttpResponse
    suspend fun assignTask(workerId: Int, taskId: Int): HttpResponse
}