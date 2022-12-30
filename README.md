# Spring AWS Lambda

### Tools
```bash
# to work with aws sso
npm install --dev serverless-better-credentials

serverless deploy

# serverless.yml
plugins:
  - serverless-better-credentials # as the first plugin
  # - ... other plugins
```

https://www.serverless.com/plugins/serverless-better-credentials