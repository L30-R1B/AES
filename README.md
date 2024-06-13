# AES

Este é um guia para o uso do algoritmo de criptografia simétrica AES em Java. 
Os comandos serão dados como argumentos na chamada do programa.

## Comandos

### CRIPT

**Chamada:**
```
CRIPT <String k> <String initFile> <String encFile> <char m>
```
Comando utilizado para criptografar um arquivo de texto. Utilize os seguintes argumentos:

- `k`: Chave de codificação.
- `initFile`: Caminho para o arquivo de texto que será criptografado.
- `encFile`: Caminho onde será armazenado o texto cifrado.
- `m`: 'n' se o arquivo "initFile" deve ser apagado ao fim do comando, ou qualquer outro valor caso contrário.

### DCRIP

**Chamada:**
```
DCRIP <String k> <String initFile> <String decFile> <char m>
```
Comando utilizado para decriptografar um arquivo de texto. Utilize os seguintes argumentos:

- `k`: Chave de decodificação.
- `initFile`: Caminho para o arquivo de texto que será decriptografado.
- `decFile`: Caminho onde será armazenado o texto decifrado.
- `m`: 'n' se o arquivo "initFile" deve ser apagado ao fim do comando, ou qualquer outro valor caso contrário.
