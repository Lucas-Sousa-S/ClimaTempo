import requests

# Defina sua chave de API
API_KEY = "sua_chave_de_api_aqui"

# Base da URL da API do ClimaTempo
BASE_URL = "http://api.openweathermap.org/data/2.5/weather"

# 1. Solicite o nome da cidade ao usuário
cidade = input("Por favor, digite o nome da cidade: ")

# Parâmetros da requisição, incluindo a cidade e a chave de API
params = {
    "q": cidade,
    "appid": API_KEY,
    "lang": "pt_br",
    "units": "metric" # Para obter a temperatura em Celsius
}

try:
    # 2. Faça a requisição à API usando a cidade fornecida pelo usuário
    response = requests.get(BASE_URL, params=params)
    response.raise_for_status() # Lança um erro para requisições com status ruim

    data = response.json()

    # Verifique se a requisição foi bem-sucedida e se há dados de clima
    if response.status_code == 200:
        temperatura = data['main']['temp']
        sensacao_termica = data['main']['feels_like']
        umidade = data['main']['humidity']
        velocidade_vento = data['wind']['speed']
        descricao = data['weather'][0]['description']
        
        # 3. Exiba as informações formatadas para o usuário
        print("\n--- Previsão do Tempo ---")
        print(f"Local: {data['name']}")
        print(f"Temperatura: {temperatura}°C")
        print(f"Sensação Térmica: {sensacao_termica}°C")
        print(f"Umidade: {umidade}%")
        print(f"Vento: {velocidade_vento} m/s")
        print(f"Condição: {descricao.capitalize()}")
        print("-------------------------\n")
    else:
        # 4. Trate o caso de cidade não encontrada
        print(f"Erro: Não foi possível encontrar a cidade '{cidade}'.")

except requests.exceptions.RequestException as e:
    print(f"Erro na requisição: {e}")
except KeyError:
    print("Erro ao processar os dados do clima. A estrutura da resposta pode estar incorreta.")
