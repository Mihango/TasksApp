package ke.co.tracom.tasks.statistics

import ke.co.tracom.tasks.data.Task

internal fun getActiveAndCompletedStats(tasks: List<Task>?): StatsResults {
    return if (tasks == null || tasks.isEmpty()) {
        StatsResults(0f, 0f)
    } else {
        val totalTasks = tasks.size
        val numberOfActiveTask = tasks.count { it.isActive }
        StatsResults(
            activeTaskPercent = 100f * numberOfActiveTask / totalTasks,
            completedTasksPercentage = 100f * (totalTasks - numberOfActiveTask) / totalTasks
        )
    }
}

data class StatsResults(val activeTaskPercent: Float, val completedTasksPercentage: Float)