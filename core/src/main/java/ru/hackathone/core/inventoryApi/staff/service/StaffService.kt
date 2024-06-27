package ru.hackathone.core.inventoryApi.staff.service

import ru.hackathone.core.inventoryApi.staff.models.Staff
import ru.hackathone.core.inventoryApi.staff.models.Task
import ru.hackathone.core.inventoryApi.staff.models.TaskStatus

interface StaffService {
    suspend fun getTaskList(): Array<Task>
    suspend fun getTaskListByStatus(taskStatus: TaskStatus): Array<Task>
    suspend fun getTaskById(taskId: Int): Task
    suspend fun getWorkedTasksById(taskId: Int): Array<Task>

    suspend fun createTask(task: Task)
    suspend fun updateTask(taskId: Int, task: Task)
    suspend fun deleteTask(taskId: Int)

    suspend fun getStatusList(): Array<TaskStatus>
    suspend fun getStaffList(): Array<Staff>

    suspend fun assignTask(workerId: Int, taskId: Int)
}