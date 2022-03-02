# Spring Boot Auditing

This project demonstrate the use of _**spring-data-envers**_ dependency for auditing purpose.

# Points to remember
- Create Repository interface by extending `RevisionRepository`
- Updated entity class by annotation `@Audited`
- Main class updated with annotation `@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)`
- Revision history printed in console

# Details 

3 Books added in database :

![img.png](img.png)

updated pages of 3rd book :

![img_1.png](img_1.png)

Book update details recorded by audit table :

![img_2.png](img_2.png)

REVTYPE gives the details about previous and current number of pages.

Book updates timestamp details :

![img_3.png](img_3.png)
