package main

import (
	"fmt"
	models "es/holiday-calendar/models"
	service "es/holiday-calendar/services"
)

/*
	This function is the entry point application.
*/
func main() {
	fmt.Printf("Hello World.")
	var holiday models.Holiday
	holiday.HolidayId = 4
	fmt.Printf("%d", holiday.HolidayId)
	
	service.AddHoliday(holiday)
}