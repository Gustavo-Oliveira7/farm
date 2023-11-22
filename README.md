
## Rotas da Aplicação


 ### 1. POST /farms

<details>
  <summary> Cria uma nova fazenda a partir dos dados recebidos </summary> </br>


| Parâmetro   | Tipo       |
| :---------- | :--------- |
| `name` | `string` | 
| `size` | `number` | 


  <summary>🔍 Formato/exemplo de requisição e resposta</summary><br />

Exemplo de requisição:
```json
{
  "name": "Fazendinha",
  "size": 5
}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "name": "Fazendinha",
  "size": 5
}
```


</details>



### 2. GET /farms
<details><summary>Retorna uma lista com todas as fazendas
</summary><br />

  <summary>🔍 Formato/exemplo de resposta</summary><br />

Exemplo de resposta:

```json
[
  {
    "id": 1,
    "name": "Fazendinha",
    "size": 5.0
  },
  {
    "id": 2,
    "name": "Fazenda do Júlio",
    "size": 2.5
  }
]
```

</details>

### 3. GET /farms/{id}

<details><summary>Retorna uma fazenda com o id passado por parâmetro
</summary><br />

<summary>🔍 Formato/exemplo de resposta</summary><br />

Exemplo de resposta para a rota `/farms/3` (supondo que exista uma fazenda com `id = 3`):

```json
{
  "id": 3,
  "name": "My Cabbages!",
  "size": 3.49
}
```

 - Caso não exista uma fazenda com esse `id`, a rota retorna o status HTTP 404 com a
      mensagem `Fazenda não encontrada!` no corpo da resposta.
</details>

 ### 4. POST /farms/{farmId}/crops

<details>
  <summary> Cria uma plantação a partir dos dados recebidos, associada à fazenda com o ID recebido </summary> </br>


| Parâmetro   | Tipo       |
| :---------- | :--------- |
| `name` | `string` | 
| `plantedArea` | `number` | 


  <summary>🔍 Formato/exemplo de requisição e resposta</summary><br />
  Exemplo de requisição na rota `/farms/1/crops` (supondo que exista uma fazenda com `id = 1`): 

```json
{
  "name": "Couve-flor",
  "plantedArea": 5.43
}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "name": "Couve-flor",
  "plantedArea": 5.43,
  "farmId": 1
}
```
- Note que o `id` da resposta se refere à plantação, e que o da fazenda está em `farmId`.
- Caso não exista uma fazenda com o `id` passado, a rota retorna o status HTTP 404 com a
      mensagem `Fazenda não encontrada!` no corpo da resposta.


</details>

### 5. GET /farms/{farmId}/crops

<details><summary>Retorna uma lista de plantações de uma fazenda.
</summary><br />

<summary>🔍 Formato/exemplo de resposta</summary><br />

Exemplo de resposta para a rota `/farms/1/crops` (supondo que exista uma fazenda com `id = 1`):

```json
[
  {
    "id": 1,
    "name": "Couve-flor",
    "plantedArea": 5.43,
    "farmId": 1
  },
  {
    "id": 2,
    "name": "Alface",
    "plantedArea": 21.3,
    "farmId": 1
  }
]
```

 - Caso não exista uma fazenda com esse `id`, a rota retorna o status HTTP 404 com a
      mensagem `Fazenda não encontrada!` no corpo da resposta.
</details>

### 6. GET /crops

<details><summary>Lista todas as plantações cadastradas
</summary><br />

<summary>🔍 Formato/exemplo de resposta</summary><br />


```json
[
  {
    "id": 1,
    "name": "Couve-flor",
    "plantedArea": 5.43,
    "farmId": 1
  },
  {
    "id": 2,
    "name": "Alface",
    "plantedArea": 21.3,
    "farmId": 1
  },
  {
    "id": 3,
    "name": "Tomate",
    "plantedArea": 1.9,
    "farmId": 2
  }
]
```

</details>

### 7. GET /crops/{id}

<details><summary>Retorna as informações de uma plantação com o id passado por parâmetro
</summary><br />

<summary>🔍 Formato/exemplo de resposta</summary><br />


Exemplo de resposta para a rota `/crops/3` (supondo que exista uma plantação com `id = 3`:

```json
{
  "id": 3,
  "name": "Tomate",
  "plantedArea": 1.9,
  "farmId": 2
}
```

- Caso não exista uma plantação com o `id` passado, a rota deve retornar o status HTTP 404 com a
      mensagem `Plantação não encontrada!` no corpo da resposta.

</details>
