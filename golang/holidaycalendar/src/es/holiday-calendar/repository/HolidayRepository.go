package repository

import (
	models "es/holiday-calendar/models"
	connection "es/holiday-calendar/repository/db"
)

func Add(holiday models.Holiday) {
	connection.GetConnection()
}

func Update(holiday models.Holiday) {

}

func Remove(holiday models.Holiday) {

}

func List() {

}