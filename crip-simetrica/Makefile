# Variáveis
JAVAC = javac
JAVA = java
SRC_DIR = src/core
BIN_DIR = bin
MAIN_CLASS = Main

# Targets
all: $(BIN_DIR)/$(MAIN_CLASS).class

$(BIN_DIR)/$(MAIN_CLASS).class: $(SRC_DIR)/$(MAIN_CLASS).java
	mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $<

run: $(BIN_DIR)/$(MAIN_CLASS).class
	$(JAVA) -cp $(BIN_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(BIN_DIR)
