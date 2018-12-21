package services
/*
	Service responsible of implements the bussiness logic.
*/
import (
	models "es/holiday-calendar/models"
	repository "es/holiday-calendar/repository"
)


/*
	Function responsible to verified business rulers.
*/
func AddHoliday(holiday models.Holiday) {
	repository.Add(holiday)
}
/*
	Function responsible to update holiday.
*/
func UpdateHoliday(holiday models.Holiday) {
	repository.Update(holiday)
}
/*
	Function responsible to remove holiday.
*/
func RemoveHoliday(holiday models.Holiday) {
	repository.Remove(holiday)
}
/*
	Function responsible to list holiday.
*/
func ListHolidays() {
	repository.List()
}