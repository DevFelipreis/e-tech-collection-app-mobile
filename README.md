# e-Tech Collection App

## Descrição
O **e-Tech Collection** é um aplicativo desenvolvido em **Kotlin** utilizando **Jetpack Compose** para a interface do usuário. O backend será integrado ao **Firebase**, e o aplicativo consumirá a **API do Dog CEO** para login e cadastro de usuários, além de utilizar o **Google Maps** para funcionalidades de localização e registro de pontos de coleta de e-waste.

## Estrutura do Projeto

### Frontend (Jetpack Compose)
- **CreateProfile.kt**: Tela de criação de perfil do usuário.
- **Feed.kt**: Tela que exibe o feed de conteúdo relevante.
- **LoginActivity.kt**: Tela de login do usuário.
- **MainActivity.kt**: Tela principal do aplicativo.
- **MenuNavigationDrawer.kt**: Menu de navegação lateral.
- **MyCollectionPoint.kt**: Tela que lista os pontos de coleta do usuário.
- **RegisterCollectionPoint.kt**: Tela para registro de novos pontos de coleta.
- **UpdateProfile.kt**: Tela para atualização das informações do perfil do usuário.

### Backend (Firebase)
- **Autenticação**: Utiliza **Firebase Authentication** para login e cadastro de usuários.
- **Banco de Dados**: Utiliza **Firestore** para armazenar dados dos usuários e dos pontos de coleta.
- **Armazenamento**: Utiliza **Firebase Storage** para armazenar imagens de perfil e outros arquivos.
- **Notificações**: Utiliza **Firebase Cloud Messaging** para enviar notificações aos usuários.

## Funcionalidades

### Login e Cadastro
- **API Dog CEO**: Utilizada para facilitar o login e o cadastro de usuários.
- **Firebase Authentication**: Integração com Firebase para autenticação segura e confiável.

### Mapas
- **Google Maps**: Integração com Google Maps para exibir e registrar pontos de coleta de e-waste.

### Perfil do Usuário
- **Criação e Atualização de Perfil**: Telas dedicadas para criar e atualizar o perfil do usuário.
- **Armazenamento de Imagens**: Utilização do Firebase Storage para armazenar imagens de perfil de forma eficiente.

### Feed
- **Exibição de Conteúdo**: Tela de feed que apresenta conteúdo relevante aos usuários, como notícias e atualizações sobre a coleta de e-waste.

## Configuração do Projeto

### Pré-requisitos
- **Android Studio**: Ambiente de desenvolvimento para Android.
- **Conta no Firebase**: Para configurar o backend.
- **Chave de API do Google Maps**: Necessária para a integração com o Google Maps.

### Passos para Configuração

1. **Clone o Repositório**
   ```bash
   git clone git@github.com:DevFelipreis/e-tech-collection-app-mobile.git
   ```

2. **Configuração do Firebase**
   - Crie um novo projeto no [Firebase Console](https://console.firebase.google.com/).
   - Adicione o aplicativo Android ao projeto Firebase.
   - Baixe o arquivo `google-services.json` e coloque-o na pasta `app` do seu projeto.

3. **Configuração do Google Maps**
   - Obtenha uma chave de API do [Google Cloud Console](https://console.cloud.google.com/).
   - Adicione a chave de API ao arquivo `AndroidManifest.xml`:
     ```xml
     <meta-data
         android:name="com.google.android.geo.API_KEY"
         android:value="SUA_CHAVE_DE_API_AQUI"/>
     ```

4. **Dependências**
   - Adicione as seguintes dependências do Firebase e Google Maps ao arquivo `build.gradle`:
     ```groovy
     implementation 'com.google.firebase:firebase-auth:21.0.1'
     implementation 'com.google.firebase:firebase-firestore:24.0.1'
     implementation 'com.google.firebase:firebase-storage:20.0.1'
     implementation 'com.google.android.gms:play-services-maps:18.0.2'
     ```

5. **Sincronize o Projeto**
   - Sincronize o projeto com o Gradle para garantir que todas as dependências sejam baixadas corretamente.
  

## Colaboradores

Este projeto foi desenvolvido com a colaboração dos seguintes membros:

- [Luiz Felipe Reis](https://github.com/DevFelipreis1)
- [Márcio Evandro](https://github.com/marevandro)
- [Waldecy Junior](https://github.com/waldecyfa)
- [Emanuel Borges](https://github.com/emanueleborges)

## Contribuição
Para contribuir com o projeto, siga os seguintes passos:
1. Faça um fork do repositório.
2. Crie uma nova branch para a sua funcionalidade:
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```
3. Faça commit das suas alterações:
   ```bash
   git commit -m 'Adiciona nova funcionalidade'
   ```
4. Faça push para a branch:
   ```bash
   git push origin feature/nova-funcionalidade
   ```
5. Abra um Pull Request para revisão.

## Licença
Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
