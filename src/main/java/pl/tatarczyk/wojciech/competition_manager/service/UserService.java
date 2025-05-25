package pl.tatarczyk.wojciech.competition_manager.service;

import org.springframework.stereotype.Service;
import pl.tatarczyk.wojciech.competition_manager.api.exception.UserNotFoundException;
import pl.tatarczyk.wojciech.competition_manager.repository.UserRepository;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.UserEntity;
import pl.tatarczyk.wojciech.competition_manager.service.mapper.UserMapper;
import pl.tatarczyk.wojciech.competition_manager.web.model.UserModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private UserMapper userMapper;
    private UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public List<UserModel> list() {
        LOGGER.info("list()");

        List<UserEntity> userEntities = userRepository.findAll();

        LOGGER.info("entities = " + userEntities);

        List<UserModel> userModels = userMapper.formEntities(userEntities);

        LOGGER.info("list(...) = " + userModels);
        return userModels;
    }

    public UserModel create(UserModel userModel) {
        LOGGER.info("create(" + userModel + ")");

        userModel.setCreatedDate(LocalDate.now());

        UserEntity mappedUserEntity = userMapper.from(userModel);
        UserEntity savedUserEntity = userRepository.save(mappedUserEntity);

        UserModel savedUserModel = userMapper.from(savedUserEntity);
        LOGGER.info("create(...) = " + savedUserModel);
        return savedUserModel;
    }

    public UserModel read(Long id) throws UserNotFoundException {
        LOGGER.info("read(" + id +")");

        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        UserEntity userEntity = optionalUserEntity.orElseThrow(
                () -> new UserNotFoundException("Not found User with id " + id)
        );

        UserModel findUserModel = userMapper.from(userEntity);
        LOGGER.info("read(...) = " + findUserModel);
        return findUserModel;
    }

    public UserModel update(UserModel userModel) {
        LOGGER.info("Update("+userModel+")");

        userModel.setModifyDate(LocalDate.now());

        UserEntity mappedUserEntity = userMapper.from(userModel);
        UserEntity updateUserEntity = userRepository.save(mappedUserEntity);

        return userMapper.from(updateUserEntity);
    }

    public void delete(Long id) {
        LOGGER.info("delete("+id+")");
        userRepository.deleteById(id);
    }
}
