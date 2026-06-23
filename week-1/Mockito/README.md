# Mockito Practice - Week 1

This folder contains basic programs and test cases created while learning Mockito. Mockito is a Java framework that helps in unit testing by creating dummy objects instead of using actual dependencies.

## What I Learned

* Creating mock objects
* Stubbing method responses
* Verifying method calls
* Using spies
* Capturing method arguments
* Testing service classes with mocked dependencies

## Important Mockito Features

| Feature        | Usage                               |
| -------------- | ----------------------------------- |
| Mock           | Creates a dummy object for testing  |
| Verify         | Checks whether a method was called  |
| Spy            | Creates a partial mock of an object |
| ArgumentCaptor | Captures values passed to methods   |
| InOrder        | Verifies method call sequence       |

## Common Annotations

* @Mock
* @InjectMocks
* @Spy
* @Captor
* @ExtendWith(MockitoExtension.class)

## Files Included

| File Name            | Description                             |
| -------------------- | --------------------------------------- |
| UserRepository.java  | Repository layer used as dependency     |
| UserService.java     | Service class containing business logic |
| UserServiceTest.java | Mockito test cases for service methods  |

## Objective

The purpose of this practice is to understand how Mockito can be used along with JUnit to test Java applications by mocking dependencies and verifying interactions between classes.
