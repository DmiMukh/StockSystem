package ru.hackathone.core.inventoryApi.staff.service

import ru.hackathone.core.inventoryApi.staff.dto.TaskRequest
import ru.hackathone.core.inventoryApi.staff.models.Staff
import ru.hackathone.core.inventoryApi.staff.models.Task
import ru.hackathone.core.inventoryApi.staff.models.TaskStatus

interface StaffService {
    suspend fun getTaskList(): Array<Task>
    suspend fun getTaskListByStatus(statusName: String): Array<Task>

    suspend fun createTask(task: TaskRequest):Int
    suspend fun updateTask(taskId: Int, task: TaskRequest)
    suspend fun deleteTask(taskId: Int, statusId: Int)

    suspend fun getStatusList(): Array<TaskStatus>

    suspend fun getStaffList(): Array<Staff>
    suspend fun getWorkerTasksById(workerId: Int): Array<Task>

    suspend fun assignTask(workerId: Int, taskId: Int)
}