---

# e-Tech Collection

## Descrição
Este é um aplicativo desenvolvido em Kotlin utilizando Jetpack Compose para a interface do usuário. O backend será integrado com Firebase, e o aplicativo consumirá a API do Dog CEO para login e cadastro de usuários, além de utilizar o Google Maps para funcionalidades de localização.

## Estrutura do Projeto

### Frontend (Jetpack Compose)
- **CreateProfile.kt**: Tela de criação de perfil.
- **Feed.kt**: Tela de feed.
- **LoginActivity.kt**: Tela de login.
- **MainActivity.kt**: Tela principal do aplicativo.
- **MenuNavigationDrawer.kt**: Menu de navegação lateral.
- **MyCollectionPoint.kt**: Tela de pontos de coleta do usuário.
- **RegisterCollectionPoint.kt**: Tela de registro de novos pontos de coleta.
- **UpdateProfile.kt**: Tela de atualização de perfil.

### Backend (Firebase)
- **Autenticação**: Utiliza Firebase Authentication para login e cadastro de usuários.
- **Banco de Dados**: Utiliza Firestore para armazenar dados dos usuários e pontos de coleta.
- **Armazenamento**: Utiliza Firebase Storage para armazenar imagens de perfil e outros arquivos.
- **Notificações**: Utiliza Firebase Cloud Messaging para enviar notificações aos usuários.

## Funcionalidades

### Login e Cadastro
- **API Dog CEO**: Utilizada para login e cadastro de usuários.
- **Firebase Authentication**: Integração com Firebase para autenticação segura.

### Mapas
- **Google Maps**: Integração com Google Maps para exibir e registrar pontos de coleta.

### Perfil do Usuário
- **Criação e Atualização de Perfil**: Telas para criar e atualizar o perfil do usuário.
- **Armazenamento de Imagens**: Utiliza Firebase Storage para armazenar imagens de perfil.

### Feed
- **Exibição de Conteúdo**: Tela de feed para exibir conteúdo relevante aos usuários.

## Configuração do Projeto

### Pré-requisitos
- Android Studio
- Conta no Firebase
- Chave de API do Google Maps

### Passos para Configuração

1. **Clone o Repositório**
   ```bash
   git@github.com:DevFelipreis/e-tech-collection-app-mobile.git
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
   - Adicione as dependências do Firebase e Google Maps ao arquivo `build.gradle`:
     ```groovy
     implementation 'com.google.firebase:firebase-auth:21.0.1'
     implementation 'com.google.firebase:firebase-firestore:24.0.1'
     implementation 'com.google.firebase:firebase-storage:20.0.1'
     implementation 'com.google.android.gms:play-services-maps:18.0.2'
     ```

5. **Sincronize o Projeto**
   - Sincronize o projeto com o Gradle para baixar todas as dependências.

## Contribuição
- Faça um fork do projeto.
- Crie uma nova branch (`git checkout -b feature/nova-funcionalidade`).
- Faça commit das suas alterações (`git commit -m 'Adiciona nova funcionalidade'`).
- Faça push para a branch (`git push origin feature/nova-funcionalidade`).
- Abra um Pull Request.

## Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.



---
