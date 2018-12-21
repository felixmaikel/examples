package db

import (
	"os"
	sql "database/sql"
	_ "github.com/mattn/go-sqlite3"
	filePath "path/filepath"
	"fmt"
	"strings"
	"log"
)

const (
	PATH_DB_FILE = "calendardb.sqlite"
	SEPARATOR = os.PathSeparator //PathSeparator is a simple character.
	SQLITE = "sqlite3"
	TEST_SELECT = "SELECT * FROM CALENDAR"
)

func GetConnection() (*sql.DB, error) {
	strArray := []string{os.TempDir(), string(SEPARATOR), PATH_DB_FILE}
	dbPath := strings.Join(strArray, "")
	file, err := os.Stat(dbPath)
	
	if err != nil && os.IsNotExist(err) {
		db, err := sql.Open(SQLITE, dbPath)
		if err != nil {
			log.Fatal("Error to create data base file."+err.Error())
			return db, err
		} else {
			fmt.Printf(file.Name())
			createTables(db)
		}
		defer db.Close()
		
		return db, err	 
	}else {
		db, err := sql.Open(SQLITE, dbPath)
		if err != nil {
			log.Fatal("Error to open data base file.")
			return db, err
		}
		return db, err
	}
	
}

func createTables(db *sql.DB) {
	ex, err := os.Executable();
	if err == nil {
		fmt.Printf(filePath.Dir(ex))
		_, exception := db.Exec(TEST_SELECT)
		
		if exception == nil {
			fmt.Printf("Correcto")
		}
	}
}